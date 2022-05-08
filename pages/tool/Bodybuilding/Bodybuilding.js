// index.js
// 获取应用实例
const app = getApp()

Page({
 /**
   * 页面的初始数据
   */
  data: {
    codeImg:null
  },
  detailbutton(e){
    let that = this;
    var id1 = e.currentTarget.dataset.id;
    console.log("body-button-id:"+e.currentTarget.dataset.id);
    wx.navigateTo({
      url: '../BodyDetail/bodydetail?id=' + id1,
})
  },
  onLoad:function(e){
    var that=this;
      wx.request({
          url: 'http://localhost:8080/Healthy/body-building',
          method: "POST",
          header: {
              'content-type': 'application/x-www-form-urlencoded'
            },
            data: {
              type:"bodylist",
            },
            success: function(res){
            console.log(res.data)
              that.setData({
                  commonlist:res.data,
             })
            }
      })
  }
})




  
 

