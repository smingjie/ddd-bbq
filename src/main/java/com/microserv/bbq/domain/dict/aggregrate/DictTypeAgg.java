package com.microserv.bbq.domain.dict.aggregrate;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.microserv.bbq.domain.common.factory.RepositoryFactory;
import com.microserv.bbq.domain.dict.entity.DictEntity;
import com.microserv.bbq.domain.dict.entity.DictItemEntity;
import com.microserv.bbq.domain.dict.entity.DictTypeEntity;
import com.microserv.bbq.domain.dict.repository.DictRepository;
import com.microserv.bbq.infrastructure.general.extension.annotation.ddd.DomainAggregate;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 领域模型--聚合 ,聚合根取字典类型
 *
 * @author jockeys
 * @since 2020/4/6
 */
@Setter
@Getter
@Accessors(chain = true)
@DomainAggregate
public class DictTypeAgg extends DictTypeEntity {
    private List<DictItemEntity> itemList;

    public DictTypeAgg(String type) {
        super(type);
    }

    private DictTypeAgg fetch() {
        if (Objects.nonNull(this.getType())) {
            List<DictEntity> dictEntities = RepositoryFactory.get(DictRepository.class).selectByType(this.getType());
            if (!CollectionUtils.isEmpty(dictEntities)) {
                this.setName(dictEntities.get(0).getName());
                this.setItemList(dictEntities.stream().map(DictItemEntity::new).collect(Collectors.toList()));
            }

            return this;
        }

        return this;
    }

    /**
     * 根据字典类型来获取此类型的字典聚合
     *
     * @param type 字典类型
     * @return 字典类型聚合结果
     */
    public static DictTypeAgg newInstanceByType(String type) {
        return new DictTypeAgg(type).fetch();
    }
}

