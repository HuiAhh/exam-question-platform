package com.huiahh.cartexam.generator.service.impl;

import com.huiahh.cartexam.generator.entity.Admin;
import com.huiahh.cartexam.generator.mapper.AdminMapper;
import com.huiahh.cartexam.generator.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.huiahh.cartexam.generator.exception.bizException.BizException;

/**
* <p>
* 管理员表 服务实现类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Slf4j
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Override
    public Page<Admin> listAdminsByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询admin: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<Admin> queryWrapper =  new QueryWrapper<Admin>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<Admin> result = super.page(new Page<>(page, pageSize));
        log.info("分页查询admin完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public Admin getAdminById(int id) {
        log.info("正在查询admin中id为{}的数据",id);
        Admin admin = super.getById(id);
        log.info("查询id为{}的admin{}",id,(null == admin?"无结果":"成功"));
        return admin;
    }

    @Override
    public Integer insertAdmin(Admin admin) {
        log.info("正在插入admin");
        if (super.save(admin)) {
            log.info("插入admin成功,id为{}",admin.getAdminId());
            return admin.getAdminId();
        } else {
            log.error("插入admin失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteAdminById(int id) {
        log.info("正在删除id为{}的admin",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的admin成功",id);
            return id;
        } else {
            log.error("删除id为{}的admin失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateAdmin(Admin admin) {
        log.info("正在更新id为{}的admin",admin.getAdminId());
        if (super.updateById(admin)) {
            log.info("更新d为{}的admin成功",admin.getAdminId());
            return admin.getAdminId();
        } else {
            log.error("更新id为{}的admin失败",admin.getAdminId());
            throw new BizException("更新失败[id=" + admin.getAdminId() + "]");
        }
    }

}
