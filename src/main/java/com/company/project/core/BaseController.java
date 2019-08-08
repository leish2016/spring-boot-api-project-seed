package com.company.project.core;

import com.company.project.domain.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 基本的CRUD功能
 * @author leish
 */
public class BaseController<T> {

    @Resource
    AbstractService service;

    @PostMapping
    public Result add(T model) {
        service.save(model);
        return Result.genSuccessResult(model);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        service.deleteById(id);
        return Result.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody T model) {
        service.update(model);
        return Result.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        return Result.genSuccessResult(service.findById(id));
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = service.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return Result.genSuccessResult(pageInfo);
    }
}
