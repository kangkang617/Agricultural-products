package com.kangkang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 *
 * </p>
 *
 * @author kangkang
 * @since 2022-05-01
 */
@TableName("t_product")
@ApiModel(value = "Product对象", description = "")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "pid", type = IdType.AUTO)
    private Integer pid;

    @ApiModelProperty("产地")
    private String address;

    @ApiModelProperty("农场概况")
    private String addressInfo;

    @ApiModelProperty("收割时间")
    private LocalDateTime harvestTime;

    @ApiModelProperty("播种图片")
    private String sowImg;

    @ApiModelProperty("播种时间")
    private String sowTime;

    @ApiModelProperty("成熟图片")
    private String ripeImg;

    @ApiModelProperty("成熟时间")
    private LocalDateTime ripeTime;

    @ApiModelProperty("生长图片")
    private String growImg;

    @ApiModelProperty("生长时间")
    private LocalDateTime growTime;

    @ApiModelProperty("成长过程描述")
    private String growDesc;

    @ApiModelProperty("农民id")
    private Integer fid;

    @ApiModelProperty("收割图片")
    private String harvestImg;

    @ApiModelProperty("农场负责人")
    private String farmCharge;

    @ApiModelProperty("创建时间")
    private LocalDateTime creatTime;

    @ApiModelProperty("修改时间")
    private LocalDateTime modifyTime;

    @ApiModelProperty("播种图标")
    private String sowIcon;

    @ApiModelProperty("施肥图标")
    private String fertIcon;

    @ApiModelProperty("生长图标")
    private String growIcon;

    @ApiModelProperty("成熟图标")
    private String ripeIcon;

    @ApiModelProperty("施肥时间")
    private LocalDateTime fertTime;

    @ApiModelProperty("施肥图片")
    private String fertImg;

    @ApiModelProperty("加工厂名称")
    private String processName;

    @ApiModelProperty("质检人员")
    private String qualityPerson;

    @ApiModelProperty("加工人员")
    private String processPerson;

    @ApiModelProperty("加工时间")
    private LocalDateTime processDate;

    @ApiModelProperty("仓储地点")
    private String storageLocation;

    @ApiModelProperty("运输人")
    private String tranPerson;

    @ApiModelProperty("出发地")
    private String starLocation;

    @ApiModelProperty("到达地")
    private String endLocation;

    @ApiModelProperty("售卖价格")
    private BigDecimal salePrice;

    @ApiModelProperty("售卖时间")
    private LocalDateTime saleTime;

    @ApiModelProperty("溯源码")
    private String sourceCode;

    @ApiModelProperty("作物名称")
    private String pName;

    @ApiModelProperty("园区")
    private String park;

    @ApiModelProperty("园区负责人")
    private String charge;

    @ApiModelProperty("园区温度")
    private String tempreature;

    @ApiModelProperty("园区湿度")
    private String humidity;

    @ApiModelProperty("关照强度")
    private String light;

    @ApiModelProperty("土壤湿度")
    private String soil;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }
    public LocalDateTime getHarvestTime() {
        return harvestTime;
    }

    public void setHarvestTime(LocalDateTime harvestTime) {
        this.harvestTime = harvestTime;
    }
    public String getSowImg() {
        return sowImg;
    }

    public void setSowImg(String sowImg) {
        this.sowImg = sowImg;
    }
    public String getSowTime() {
        return sowTime;
    }

    public void setSowTime(String sowTime) {
        this.sowTime = sowTime;
    }
    public String getRipeImg() {
        return ripeImg;
    }

    public void setRipeImg(String ripeImg) {
        this.ripeImg = ripeImg;
    }
    public LocalDateTime getRipeTime() {
        return ripeTime;
    }

    public void setRipeTime(LocalDateTime ripeTime) {
        this.ripeTime = ripeTime;
    }
    public String getGrowImg() {
        return growImg;
    }

    public void setGrowImg(String growImg) {
        this.growImg = growImg;
    }
    public LocalDateTime getGrowTime() {
        return growTime;
    }

    public void setGrowTime(LocalDateTime growTime) {
        this.growTime = growTime;
    }
    public String getGrowDesc() {
        return growDesc;
    }

    public void setGrowDesc(String growDesc) {
        this.growDesc = growDesc;
    }
    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }
    public String getHarvestImg() {
        return harvestImg;
    }

    public void setHarvestImg(String harvestImg) {
        this.harvestImg = harvestImg;
    }
    public String getFarmCharge() {
        return farmCharge;
    }

    public void setFarmCharge(String farmCharge) {
        this.farmCharge = farmCharge;
    }
    public LocalDateTime getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(LocalDateTime creatTime) {
        this.creatTime = creatTime;
    }
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }
    public String getSowIcon() {
        return sowIcon;
    }

    public void setSowIcon(String sowIcon) {
        this.sowIcon = sowIcon;
    }
    public String getFertIcon() {
        return fertIcon;
    }

    public void setFertIcon(String fertIcon) {
        this.fertIcon = fertIcon;
    }
    public String getGrowIcon() {
        return growIcon;
    }

    public void setGrowIcon(String growIcon) {
        this.growIcon = growIcon;
    }
    public String getRipeIcon() {
        return ripeIcon;
    }

    public void setRipeIcon(String ripeIcon) {
        this.ripeIcon = ripeIcon;
    }
    public LocalDateTime getFertTime() {
        return fertTime;
    }

    public void setFertTime(LocalDateTime fertTime) {
        this.fertTime = fertTime;
    }
    public String getFertImg() {
        return fertImg;
    }

    public void setFertImg(String fertImg) {
        this.fertImg = fertImg;
    }
    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }
    public String getQualityPerson() {
        return qualityPerson;
    }

    public void setQualityPerson(String qualityPerson) {
        this.qualityPerson = qualityPerson;
    }
    public String getProcessPerson() {
        return processPerson;
    }

    public void setProcessPerson(String processPerson) {
        this.processPerson = processPerson;
    }
    public LocalDateTime getProcessDate() {
        return processDate;
    }

    public void setProcessDate(LocalDateTime processDate) {
        this.processDate = processDate;
    }
    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }
    public String getTranPerson() {
        return tranPerson;
    }

    public void setTranPerson(String tranPerson) {
        this.tranPerson = tranPerson;
    }
    public String getStarLocation() {
        return starLocation;
    }

    public void setStarLocation(String starLocation) {
        this.starLocation = starLocation;
    }
    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }
    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }
    public LocalDateTime getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(LocalDateTime saleTime) {
        this.saleTime = saleTime;
    }
    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }
    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }
    public String getPark() {
        return park;
    }

    public void setPark(String park) {
        this.park = park;
    }
    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }
    public String getTempreature() {
        return tempreature;
    }

    public void setTempreature(String tempreature) {
        this.tempreature = tempreature;
    }
    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }
    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", address=" + address +
                ", addressInfo=" + addressInfo +
                ", harvestTime=" + harvestTime +
                ", sowImg=" + sowImg +
                ", sowTime=" + sowTime +
                ", ripeImg=" + ripeImg +
                ", ripeTime=" + ripeTime +
                ", growImg=" + growImg +
                ", growTime=" + growTime +
                ", growDesc=" + growDesc +
                ", fid=" + fid +
                ", harvestImg=" + harvestImg +
                ", farmCharge=" + farmCharge +
                ", creatTime=" + creatTime +
                ", modifyTime=" + modifyTime +
                ", sowIcon=" + sowIcon +
                ", fertIcon=" + fertIcon +
                ", growIcon=" + growIcon +
                ", ripeIcon=" + ripeIcon +
                ", fertTime=" + fertTime +
                ", fertImg=" + fertImg +
                ", processName=" + processName +
                ", qualityPerson=" + qualityPerson +
                ", processPerson=" + processPerson +
                ", processDate=" + processDate +
                ", storageLocation=" + storageLocation +
                ", tranPerson=" + tranPerson +
                ", starLocation=" + starLocation +
                ", endLocation=" + endLocation +
                ", salePrice=" + salePrice +
                ", saleTime=" + saleTime +
                ", sourceCode=" + sourceCode +
                ", pName=" + pName +
                ", park=" + park +
                ", charge=" + charge +
                ", tempreature=" + tempreature +
                ", humidity=" + humidity +
                ", light=" + light +
                ", soil=" + soil +
                "}";
    }
}
