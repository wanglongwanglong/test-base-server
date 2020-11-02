/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package cn.com.tyyxtech.frame.admin.modules.sys.entity;


import cn.com.tyyxtech.frame.common.validator.AddGroup;
import cn.com.tyyxtech.frame.common.validator.UpdateGroup;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
 * 系统用户
 *
 * @author
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:28:55
 */
@TableName("sys_user")
public class SysUserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    @ApiModelProperty(value = "")
    private Long userId;
    /**
     *
     */
    @ApiModelProperty(value = "deptId")
    private Long deptId;
    /**
     * uuid
     */
    @ApiModelProperty(value = "uuid")
    @Excel(name="uuid")
    private String uuid;
    /**
     * openid
     */
    @ApiModelProperty(value = "openid")
    @Excel(name="openid")
    private String openid;
    /**
     * 账号
     */
    @NotBlank(message = "账号不能为空", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "账号")
    @Excel(name="账号")
    private String username;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空", groups = AddGroup.class)
    @ApiModelProperty(value = "密码")
    @Excel(name="密码")
    private String password;
    /**
     * 盐
     */
    @ApiModelProperty(value = "盐")
    @Excel(name="盐")
    private String salt;
    /**
     * 地区
     */
    @ApiModelProperty(value = "地区")
    @Excel(name="地区")
    private String city;
    /**
     * 联系人
     */
    @ApiModelProperty(value = "联系人")
    @Excel(name="联系人")
    private String linkman;
    /**
     * 审核状态
     */
    @ApiModelProperty(value = "审核状态")
    @Excel(name="审核状态")
    private String audit;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @Excel(name="姓名")
    private String name;
    /**
     * 机构介绍
     */
    @ApiModelProperty(value = "机构介绍")
    @Excel(name="机构介绍")
    private String introduce;
    /**
     * 机构uuid
     */
    @ApiModelProperty(value = "机构uuid")
    @Excel(name="机构uuid")
    private String organizationUuid;
    /**
     * 审核人
     */
    @ApiModelProperty(value = "审核人")
    @Excel(name="审核人")
    private String auditor;
    /**
     * 驳回理由
     */
    @ApiModelProperty(value = "驳回理由")
    @Excel(name="驳回理由")
    private String reason;
    /**
     * 二维码
     */
    @ApiModelProperty(value = "二维码")
    @Excel(name="二维码")
    private String qr;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    @Excel(name="性别")
    private String sex;
    /**
     * 图片url
     */
    @ApiModelProperty(value = "图片url")
    @Excel(name="图片url")
    private String imageUrl;
    /**
     * 登陆时间
     */
    @ApiModelProperty(value = "登陆时间")
    @Excel(name="登陆时间")
    private String loginTime;
    /**
     * 最后登陆时间
     */
    @ApiModelProperty(value = "最后登陆时间")
    @Excel(name="最后登陆时间")
    private String lastLoginTime;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    @Excel(name="手机号")
    private String phone;
    /**
     * 状态  0：禁用   1：正常
     */
    @ApiModelProperty(value = "状态  0：禁用   1：正常")
    @Excel(name="状态  0：禁用   1：正常")
    private Integer status;
    /**
     * 禁言  0：禁用   1：正常
     */
    @ApiModelProperty(value = "禁言  0：禁用   1：允许")
    @Excel(name="禁言  0：禁用   1：允许")
    private Integer stop;

    /**
     * 用于是否展示审核按钮 0不显示.1显示
     */
    @ApiModelProperty(value = "展示审核按钮 0不显示.1显示")
    @Excel(name="展示审核按钮 0不显示.1显示")
    private Integer CheckState;


    /**
     * 文章收藏的次数
     */
    @ApiModelProperty(value = "文章收藏的次数")
    @Excel(name="文章收藏的次数")
    private Long count;
    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者")
    private Long owner;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private String createday;
    /**
     * 更新者
     */
    @ApiModelProperty(value = "更新者")
    private String updater;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private String updateday;

    /**
     * pc端和app区分
     */
    @ApiModelProperty(value = "区分用户")
    private String type;
    /**
     * 用于是否完善资料 0不显示 1显示
     */
    @ApiModelProperty(value = "用于是否完善资料")
    @Excel(name="用于是否完善资料")
    private String state;
    /**
     * 有效性
     */
    @ApiModelProperty(value = "有效性")
    @Excel(name="有效性")
    @TableLogic
    private String effective;
    /**
     * 角色ID列表
     */
    @TableField(exist = false)
    private Long roleId;
    /**
     * 用户展示层级
     */
    @TableField(exist = false)
    private List<SysUserEntity> children;
    /**
     * 机构个数
     */
    @TableField(exist = false)
    private Integer institutions;


    /**
     * 设置：
     *
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取：
     *
     * @return Long
     */
    public Long getUserId() {
        return userId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 设置：账号
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取：账号
     */
    public String getUsername() {
        return username;
    }
    /**
     * 设置：密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取：密码
     */
    public String getPassword() {
        return password;
    }
    /**
     * 设置：盐
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取：盐
     */
    public String getSalt() {
        return salt;
    }
    /**
     * 设置：姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：姓名
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取：性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置：手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取：手机号
     */
    public String getPhone() {
        return phone;
    }
    /**
     * 设置：状态  0：禁用   1：正常
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：状态  0：禁用   1：正常
     */
    public Integer getStatus() {
        return status;
    }


    /**
     * 设置：创建者
     */
    public void setOwner(Long owner) {
        this.owner = owner;
    }

    /**
     * 获取：创建者
     */
    public Long getOwner() {
        return owner;
    }
    /**
     * 设置：创建时间
     */
    public void setCreateday(String createday) {
        this.createday = createday;
    }
    /**
     * 获取：创建时间
     */
    public String getCreateday() {
        return createday;
    }
    /**
     * 设置：更新者
     */
    public void setUpdater(String updater) {
        this.updater = updater;
    }

    /**
     * 获取：更新者
     */
    public String getUpdater() {
        return updater;
    }
    /**
     * 设置：更新时间
     */
    public void setUpdateday(String updateday) {
        this.updateday = updateday;
    }


    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit;
    }

    /**
     * 获取：更新时间
     */
    public String getUpdateday() {
        return updateday;
    }
    /**
     * 设置：有效性
     */
    public void setEffective(String effective) {
        this.effective = effective;
    }

    /**
     * 获取：有效性
     */
    public String getEffective() {
        return effective;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<SysUserEntity> getChildren() {
        return children;
    }

    public void setChildren(List<SysUserEntity> children) {
        this.children = children;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getOrganizationUuid() {
        return organizationUuid;
    }

    public void setOrganizationUuid(String organizationUuid) {
        this.organizationUuid = organizationUuid;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }


    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getStop() {
        return stop;
    }

    public void setStop(Integer stop) {
        this.stop = stop;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getInstitutions() {
        return institutions;
    }

    public void setInstitutions(Integer institutions) {
        this.institutions = institutions;
    }

    public Integer getCheckState() {
        return CheckState;
    }

    public void setCheckState(Integer checkState) {
        CheckState = checkState;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
