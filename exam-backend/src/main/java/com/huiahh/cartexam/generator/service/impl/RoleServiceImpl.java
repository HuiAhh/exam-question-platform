package com.huiahh.cartexam.generator.service.impl;

import com.huiahh.cartexam.generator.entity.Role;
import com.huiahh.cartexam.generator.mapper.RoleMapper;
import com.huiahh.cartexam.generator.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.huiahh.cartexam.generator.exception.bizException.BizException;

/**
* <p>
* 角色表 服务实现类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Slf4j
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public Page<Role> listRolesByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询role: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<Role> queryWrapper =  new QueryWrapper<Role>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<Role> result = super.page(new Page<>(page, pageSize));
        log.info("分页查询role完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public Role getRoleById(int id) {
        log.info("正在查询role中id为{}的数据",id);
        Role role = super.getById(id);
        log.info("查询id为{}的role{}",id,(null == role?"无结果":"成功"));
        return role;
    }

    @Override
    public Integer insertRole(Role role) {
        log.info("正在插入role");
        if (super.save(role)) {
            log.info("插入role成功,id为{}",role.getRoleId());
            return role.getRoleId();
        } else {
            log.error("插入role失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteRoleById(int id) {
        log.info("正在删除id为{}的role",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的role成功",id);
            return id;
        } else {
            log.error("删除id为{}的role失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateRole(Role role) {
        log.info("正在更新id为{}的role",role.getRoleId());
        if (super.updateById(role)) {
            log.info("更新d为{}的role成功",role.getRoleId());
            return role.getRoleId();
        } else {
            log.error("更新id为{}的role失败",role.getRoleId());
            throw new BizException("更新失败[id=" + role.getRoleId() + "]");
        }
    }

}
