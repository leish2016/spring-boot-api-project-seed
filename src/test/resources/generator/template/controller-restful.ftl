package ${basePackage}.controller;

import ${modelPackage}.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import ${basePackage}.core.BaseController;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* @author ${author} on ${date}.
*/
@RestController
@RequestMapping("/api/${modelNameLowerCamel}")
public class ${modelNameUpperCamel}Controller extends BaseController<${modelNameUpperCamel}>{

    @Resource
    ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

}
