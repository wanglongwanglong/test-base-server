package cn.com.tyyxtech.business.modules.frame.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.jeecgframework.poi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * @author WangLong
 * @Date 2020/11/2020/11/2 11:15
 * @Description
 */
@TableName("article")
@ApiModel(value = "Article",description = "文章表实体(Article)")
public class ArticleEntity implements Serializable {



    private static final long serialVersionID = 1L;

    @TableId
    @ApiModelProperty(value = "文章uuid")
    private Integer id;

    @Excel(name = "文章详情uuid")
    @ApiModelProperty(value = "文章uuid")
    private String uuid;

    @Excel(name = "标题")
    @ApiModelProperty(value = "标题")
    private String title;

    @Excel(name = "详情uuid")
    @ApiModelProperty(value = "uuid")
    private String detailUuid;

    @Excel(name = "收藏数")
    @ApiModelProperty(value = "收藏数")
    private Integer collectNum;

    @Excel(name = "栏目uuid")
    @ApiModelProperty(value = "栏目uuid")
    private String columnUuid;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetailUuid(String detailUuid) {
        this.detailUuid = detailUuid;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public void setColumnUuid(String columnUuid) {
        this.columnUuid = columnUuid;
    }


    public Integer getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public String getDetailUuid() {
        return detailUuid;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public String getColumnUuid() {
        return columnUuid;
    }
}
