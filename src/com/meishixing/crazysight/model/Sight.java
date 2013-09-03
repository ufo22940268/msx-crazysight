package com.meishixing.crazysight.model;
import org.apache.commons.lang3.builder.ToStringBuilder;

//themeName: "山水园林",
//sceneryAddress: "浙江省杭州市西湖区转塘街道龙门坎村",
//provinceId: 31,
//provinceName: "浙江",
//lon: 120.01699671659685,
//id: 924,
//add_time: "2013-07-23 14:22:28",
//status: 2,
//update_time: "2013-09-03 04:19:00",
//distance: 1404.15844998381,
//imgPath: "2012/02/13/2/2012021313231776633.jpg",
//cityId: 383,
//lat: 30.191000074991752,
//sceneryName: "杭州白龙潭景区",
//bookFlag: 1,
//viewCount: 1,
//themeId: 12,
//gradeId: "",
//cityName: "杭州",
//amount: 60,
//adviceAmount: 40,
//sceneryId: 28946,
//scenerySummary: "白龙潭景区位于杭州市之江国家旅游度假区，是杭州西山森林公园的主入口之一。景区建有龙门山庄、茶室、互动项目等一系列配套设施，是集休闲、住宿、餐饮、特色小吃、商务、会议等功能为一体的度假型山庄，景区内设有三家各具特色且杭州自然环境最好的茶室，提供游人品茶、赏景、洽谈，让你远离喧嚣的都市，在天然氧吧中享受自然，是公司聚会、商务洽谈、休闲度假的极佳去处。"
//},
public class Sight {
    public String themeName;
    public String sceneryName;
    public String imgPath;
    public float amount;
    public float adviceAmount;

    public String getRealImage() {
        if (imgPath != null) {
            return "http://upload.17u.com/uploadfile/scenerypic_common/" + "300_225/" + imgPath;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
