const app = getApp();
Page({
  data: {
    isAuth:false, //是否授权
    username:null,
    userInfo:null
  },
  
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
    this.setData({
      userInfo:app.globalData.userInfo
    }),
    that.onGotUserInfo();
    console.log("17"+that.userInfo)
  },

  onGotUserInfo:function(e){
    var that=this;
    wx.getUserProfile({
      desc: '获取你的昵称、头像、地区及性别',
     
      success: (res1) => {
        
        wx.login({ //调用接口获取登录凭证（code）
          success: function (res) {
            console.log("encryptedData:"+res1.encryptedData)
            console.log("iv:"+res1.iv)
            console.log("code:"+res.code)
            console.log(res1.userInfo)
            if (res.code) {
              var code = res.code;
                    wx.request({
                url: "http://localhost:8080/Healthy/insert-servlet", 
                header: {
                  'content-type': 'application/x-www-form-urlencoded'
                },
                data: {
                  "code": code,
                  "encryptedData": res1.encryptedData,
                  "iv": res1.iv
                },
                method: 'POST',
                dataType: 'json',
      responseType: 'text',
                success: function (res2) {
                //解密成功后 获取自己服务器返回的结果
                var userdata=res2.data;
                 var obj=JSON.stringify(userdata);
                app.globalData.username=res2.data.username;
                app.globalData.openid=res2.data.openid;
                app.globalData.avatarUrl=res2.data.avatarUrl;
                console.log("res:"+res2.data.username),
                console.log("obj:"+obj),
                console.log("username:"+app.globalData.username),
                console.log("openid:"+app.globalData.openid),
                console.log("avatarUrl:"+app.globalData.avatarUrl),
                  that.setData({
                    username:app.globalData.username,
                    openid:app.globalData.openid,
                    avatarUrl:app.globalData.avatarUrl,
                   isAuth:true
                  })
                  
                }
              })
            }
          },
        })
      }
    })

  },

 
})