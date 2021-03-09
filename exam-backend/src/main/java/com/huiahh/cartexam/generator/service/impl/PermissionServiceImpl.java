package com.huiahh.cartexam.generator.service.impl;

import com.huiahh.cartexam.generator.entity.Permission;
import com.huiahh.cartexam.generator.mapper.PermissionMapper;
import com.huiahh.cartexam.generator.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.huiahh.cartexam.generator.exception.bizException.BizException;

/**
* <p>
* 权限表 服务实现类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Slf4j
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Override
    public Page<Permission> listPermissionsByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询permission: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<Permission> queryWrapper =  new QueryWrapper<Permission>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<Permission> result = super.page(new Page<>(page, pageSize));
        log.info("分页查询permission完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public Permission getPermissionById(int id) {
        log.info("正在查询permission中id为{}的数据",id);
        Permission permission = super.getById(id);
        log.info("查询id为{}的permission{}",id,(null == permission?"无结果":"成功"));
        return permission;
    }

    @Override
    public Integer insertPermission(Permission permission) {
        log.info("正在插入permission");
        if (super.save(permission)) {
            log.info("插入permission成功,id为{}",permission.getPermissionId());
            return permission.getPermissionId();
        } else {
            log.error("插入permission失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deletePermissionById(int id) {
        log.info("正在删除id为{}的permission",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的permission成功",id);
            return id;
        } else {
            log.error("删除id为{}的permission失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updatePermission(Permission permission) {
        log.info("正在更新id为{}的permission",permission.getPermissionId());
        if (super.updateById(permission)) {
            log.info("更新d为{}的permission成功",permission.getPermissionId());
            return permission.getPermissionId();
        } else {
            log.error("更新id为{}的permission失败",permission.getPermissionId());
            throw new BizException("更新失败[id=" + permission.getPermissionId() + "]");
        }
    }

}
