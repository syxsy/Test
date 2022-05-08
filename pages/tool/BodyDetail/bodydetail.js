const app = getApp()
Page({

    /**
     * 页面的初始数据
     */
    data: {
        title:null,
        Content:null,
        list:[]
    },
    getContent:function(e){
      this.data.Content=e.detail.value;
    },
    pingjia(){
      var that=this;
      wx.request({
        url: 'http://localhost:8080/Healthy/body-building',
        method: "POST",
        header: {
            'content-type': 'application/x-www-form-urlencoded'
          },
          data: {
            type:"insertcontent",
            title:that.data.title,
            content:that.data.Content,
            openid:app.globalData.openid,
            username:app.globalData.username,
          },
          success: function(res){
            that.setData({
              contentlist:res.data
            })
          }
      })
    },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        var that=this;
        let id1=options.id;
        console.log("bodyitemdetail-id:"+id1);
        wx.request({
            url: 'http://localhost:8080/Healthy/body-building',
            method: "POST",
            header: {
                'content-type': 'application/x-www-form-urlencoded'
              },
              data: {
                type:"onebody",
                onebodyid:  id1   
              },
              success: function(res){
                  console.log(res.data)
                  that.data.title=res.data.title
                that.setData({
                    one:res.data,
                    id:id1
                  })
                  wx.request({
                    url: 'http://localhost:8080/Healthy/body-building',
                    method: "POST",
                    header: {
                        'content-type': 'application/x-www-form-urlencoded'
                      },
                      data: {
                        type:"onebodycontent",
                        title:  res.data.title   
                      },
                      success: function(res1){
                        that.setData({
                            contentlist:res1.data
                          })
                      }

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