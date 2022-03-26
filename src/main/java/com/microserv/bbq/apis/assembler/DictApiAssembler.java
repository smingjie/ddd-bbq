package com.microserv.bbq.apis.assembler;

import com.microserv.bbq.domain.dict.entity.DictEntity;
import com.microserv.bbq.infrastructure.general.extension.annotation.ddd.DomainAssembler;
import com.microserv.bbq.infrastructure.general.extension.assembler.IApiDomainAssembler;

/**
 * API层装配器-字典域
 *
 * @author mingjie
 * @date 2022/3/20
 */
@DomainAssembler
public class DictApiAssembler implements IApiDomainAssembler<DictEntity> {
}