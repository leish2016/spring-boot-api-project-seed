package ${basePackage}.service;

import ${basePackage}.mapper.${modelNameUpperCamel}Mapper;
import ${basePackage}.model.entity.${modelNameUpperCamel};
import ${basePackage}.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author ${author} on ${date}.
 */
@Service
public class ${modelNameUpperCamel}Service extends AbstractService<${modelNameUpperCamel}> {
    @Resource
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

}
