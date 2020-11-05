package cn.com.tyyxtech.business.modules.frame.controller;

import cn.com.tyyxtech.business.modules.frame.entity.ArticleEntity;
import cn.com.tyyxtech.business.modules.frame.service.ArticleService;
import cn.com.tyyxtech.frame.admin.modules.sys.controller.AbstractController;
import cn.com.tyyxtech.frame.common.utils.EntityUtils;
import cn.com.tyyxtech.frame.common.utils.PageUtils;
import cn.com.tyyxtech.frame.common.utils.R;
import com.sun.media.jfxmedia.logging.Logger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * 手写
 * @author WangLong
 * @Date 2020/11/2020/11/2 9:05
 * @Description
 */
@RestController
@RequestMapping("frame/article")
@Api(description = "文章表",tags = "文章表(Article)")
public class ArticleController extends AbstractController{

    @Autowired
    private ArticleService articleService;

    @PostMapping("/list")
    @RequiresPermissions("frame:article:list")
    @ApiOperation(value = "",notes = "")
    public R list(@RequestParam Map<String,Object> params){
        try {

            PageUtils page = articleService.queryPage(params);
            R ok = R.ok();
            ok.put("page",params);
            return ok;
        }catch (Exception e){
            logger.debug("查询异常ArticleController--list",e);
            return R.error("查询异常ArticleController--list");
        }
    }

    @PostMapping("/info/{id}")
    @RequiresPermissions("frame:article:info")
    @ApiOperation(value = "", notes = "")
    public R info(@PathVariable("id") Integer id){
        ArticleEntity article = articleService.selectByIdEntity(id);
        return  R.ok().put("article",article);
    }

    /**
     * @Param
     * @param
     * @param
     * */
    @PostMapping("/save")
//    @SysLog()
    @RequiresPermissions("")
    @ApiOperation(value = "",notes = "")
    public R save(@RequestBody ArticleEntity article){
        try {//
            EntityUtils manager = EntityUtils.getManager();
            /**
             *
             * */
            manager.fillCommonEntity(article,this.getUserId()+"",this.getUserId()+"",new Date(),new Date());
            articleService.insertEntiyt(article);
            return R.ok().put("id",article.getId());
        }catch (Exception e){
            logger.debug("保存异常ArticleController--save");
            return R.error("保存异常ArticleController--save");
        }
    }

    @PostMapping("/update")
    @RequiresPermissions("")
    @ApiOperation(value = "",notes = "")
    public R update(){
        try {
            return null;
        }catch (Exception e){
            return  R.error("修改异常ArticleController--update");
        }//
    }//


    public R delete(){
        try {
            return null;
        }catch (Exception e){
            return  R.error("删除异常ArticleController--delete");
        }
    }

    public R insertBatch(){
        //tests

        try {
            return null;
        }catch (Exception e){
            return  R.error("批量插入异常ArticleController--insertBatch");
        }
    }
}
