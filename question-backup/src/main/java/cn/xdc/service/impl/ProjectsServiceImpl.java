package cn.xdc.service.impl;

import cn.xdc.entity.Projects;
import cn.xdc.mapper.ProjectsMapper;
import cn.xdc.service.IProjectsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author domekisuzi
 * @since 2024-07-12
 */
@Service
public class ProjectsServiceImpl extends ServiceImpl<ProjectsMapper, Projects> implements IProjectsService {

}
