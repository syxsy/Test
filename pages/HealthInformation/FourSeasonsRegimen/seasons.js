// pages/Health information/CommonSense.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
      getid:0,
      currentTab: 0,
      list:['常识','时令','食疗','运动']
  },
  swichNav: function (e) {
    console.log(e);
    var that = this;
    that.currentTab=e.target.dataset.current;
    if (this.data.currentTab === e.target.dataset.current) {
        return false;
    } else {
        that.setData({
            currentTab: e.target.dataset.current,
        })
    }
},
swiperChange: function (e) {
  this.currentTab=e.detail.current,
    console.log("currentTab:"+this.currentTab);
    var that=this;
      console.log("current"+that.data.list[that.data.currentTab]);
      wx.request({
          url: 'http://localhost:8080/Healthy/healtInfo-servlet',
          method: "POST",
          header: {
              'content-type': 'application/x-www-form-urlencoded'
            },
            data: {
              type:"all",
              tagflag:that.data.list[that.data.currentTab] 
            },
         
            success: function(res){
                console.log(res.data)
              that.setData({
                  commonlist:res.data
                })
            }
      })

},


  detailbutton:function(e){
      console.log(e);
          let that = this;
           var id1 = e.currentTarget.dataset.id;
          wx.request({
              url: 'http://localhost:8080/Healthy/healtInfo-servlet',
              method: "POST",
              header: {
                  'content-type': 'application/x-www-form-urlencoded'
                },
                data: {
                  type:"updatetone",
                  id:id1 
                },
                success: function(res){
                  console.log(res.data)
                  wx.navigateTo({
                      url: '../detail/detail?id=' + id1,
                })
                }
          })
          
  },
  /**
   * 生命周期函数--监听页面加载
   */
  ont:function(e){

  },
  onLoad: function (options) {
      var that=this;
      console.log("current"+that.data.list[that.data.currentTab]);
      wx.request({
          url: 'http://localhost:8080/Healthy/healtInfo-servlet',
          method: "POST",
          header: {
              'content-type': 'application/x-www-form-urlencoded'
            },
            data: {
              type:"all",
              tagflag:"时令"
            },
         
            success: function(res){
                console.log(res.data[0])
              that.setData({
                  commonlist:res.data
                })
            }
      })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})