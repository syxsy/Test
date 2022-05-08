// index.js
// 获取应用实例
const app = getApp()

Page({
  // 事件处理函数sciencekg_btn
  common(){
   wx.navigateTo({
     url: '../HealthInformation/CommonSense/CommonSense',
   })
 
 },
 siji(){
  wx.navigateTo({
    url: '../HealthInformation/FourSeasonsRegimen/seasons',
  })
  },
  shiliao(){
    wx.navigateTo({
      url: '../HealthInformation/diet/diet',
    })
  },
  yundong(){
    wx.navigateTo({
      url: '../HealthInformation/motion/motion',
    })
  },
  bmi(){
    wx.navigateTo({
      url: '../tool/BMIManage/bmimanage',
    })
  },
  jianshen(){
    wx.navigateTo({
      url: '../tool/Bodybuilding/Bodybuilding',
    })
  }
  
 
})
