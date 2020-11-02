package cn.com.tyyxtech.business.modules.frame.service;

        import cn.com.tyyxtech.business.modules.frame.entity.ArticleEntity;
        import cn.com.tyyxtech.frame.common.utils.PageUtils;
        import com.baomidou.mybatisplus.mapper.Wrapper;
        import com.baomidou.mybatisplus.service.IService;

        import java.io.Serializable;
        import java.util.Collection;
        import java.util.List;
        import java.util.Map;

public interface ArticleService extends IService<ArticleEntity> {


        PageUtils queryPage(Map<String, Object> params);

        ArticleEntity selectByIdEntity(Serializable id);

        boolean insertEntiyt(ArticleEntity entity);

        boolean updateAllColumnByIdEntity(ArticleEntity entity);

        boolean deleteBatchIdsEntity (Collection< ? extends  Serializable> idList);

        boolean insertBatchEntity(List<ArticleEntity> entityList);

        boolean updateBatchByIdEntity(List<ArticleEntity> entityList);

        List<ArticleEntity> selectByWrapper(Map<String,Object> params);

        List<ArticleEntity> selectByMapEntity(Map<String,Object> columnMap);

        int selectCountEntity(Wrapper<ArticleEntity> wrapper);

        List<ArticleEntity> selectListEntity(Wrapper<ArticleEntity> wrapper);

        ArticleEntity selectOneEntity(Wrapper<ArticleEntity> wrapper);


}
