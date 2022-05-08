// index.js
// 获取应用实例
const app = getApp()

Page({
 data:{
     high:0,
     weight:0,
     waist:0,
     BMI:0,
     date:null,
     healthy:null,
     illpossible:null,
     list:[]
 },
 
 getHigh: function(e){
     this.data.high=e.detail.value;
 },
 getWeight: function(e){
    this.data.weight=e.detail.value;
 },
 tianjia(){
     var that=this;
     wx.request({
        url: 'http://localhost:8080/Healthy/insert-bmi',
        method: "POST",
        header: {
            'content-type': 'application/x-www-form-urlencoded'
          },
        data: {
          username: app.globalData.username,
          openid:app.globalData.openid,
          high: that.data.high,
          weight:that.data.weight,
        },
        success: function(res){
          wx.showToast({
            title: '添加成功',
          })
           
        },
     }),
     wx.request({
      url: 'http://localhost:8080/Healthy/query-bmi',
      method: "POST",
      header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
        data:{
            type:"one",
            openid:app.globalData.openid,
        },
        success:(res)=>{
          that.setData({
            one:res.data
          })
        }
    })
    wx.request({
      url: 'http://localhost:8080/Healthy/query-bmi',
      method: "POST",
      header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
        data:{
            type:"all",
            openid:app.globalData.openid,
        },
        success:(res)=>{
            that.list=res.data.bmilist,
            console.log(res.data),
            that.setData({
              list :res.data,
            })
        }
        
    })
     
 },
 onLoad: function (options) {
  var that=this;
      wx.request({
        url: 'http://localhost:8080/Healthy/query-bmi',
        method: "POST",
        header: {
            'content-type': 'application/x-www-form-urlencoded'
          },
          data:{
              type:"all",
              openid:app.globalData.openid,
          },
          success:(res)=>{
              that.list=res.data.bmilist,
              console.log(res.data),
              that.setData({
                list :res.data,
              })
          }
          
      })
        wx.request({
          url: 'http://localhost:8080/Healthy/query-bmi',
          method: "POST",
          header: {
              'content-type': 'application/x-www-form-urlencoded'
            },
            data:{
                type:"one",
                openid:app.globalData.openid,
            },
            success:(res)=>{
              that.setData({
                one:res.data
              })
            }
        })
 }
})
