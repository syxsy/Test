// index.js
// 获取应用实例
const app = getApp()

Page({
 /**
   * 页面的初始数据
   */
  data: {
    isHealthmedicine:false,
    shows: false, //控制下拉列表的显示隐藏，false隐藏、true显示
    selectDatas: ['抗生素','心脑血管'], //下拉列表的数据
    Healthmedicine:['增强免疫力','降血糖','降血脂'],
    indexs: 0, //选择的下拉列 表下标,
    detaillist:[],
    list:[],
    isimg:false,
    urlimg:null
  },
  yaopin:function (e) {
    var that=this;
    let index=e.currentTarget.dataset.index;
    console.log("index:"+e.currentTarget.dataset.urlimg),
    wx.request({
      url: 'http://localhost:8080/Healthy/itemdetail-servlet',
      method: "POST",
      header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
      data: {
        urlimg:e.currentTarget.dataset.urlimg
      },
      success: function(res){
        console.log(res.data);
        let dlist = res.data;
        
        wx.setStorageSync("dlist",res.data[index]);
        console.log("dlist11:"+res.data[0]),
        console.log("dlist:"+dlist[index]),
        that.setData({
          detaillist:res.data
        }),
        
        wx.navigateTo({
          url: '/pages/Detail/detail',
        })
      }
    })
  },
  // 点击下拉显示框
  selectTaps() {
    this.setData({
      shows: !this.data.shows,
    });
  },
  // 点击下拉列表
  optionTaps(e) {
    var that=this;
    var url;
    let Indexs = e.currentTarget.dataset.index; //获取点击的下拉列表的下标
    console.log(Indexs),
    console.log(that.data.selectDatas[0]),
    wx.request({
      url: 'http://localhost:8080/Healthy/medicine-servlet',
      method: "POST",
      header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
      data: {
        sort:that.data.selectDatas[e.currentTarget.dataset.index]
      },
      success: function(res){
        console.log(res.data),
        wx.showToast({
          title: '添加成功',
          
        })
        that.setData({
          list:res.data,
        });
      }
     })
  },
  onLoad:function(e){
    var that=this;
    console.log("onload"+that.data.selectDatas[0])
  },
  selectTaps_health() {
    this.setData({
      isHealthmedicine: !this.data.isHealthmedicine,
    });
  },
  optionTaps_health(e) {
    var that=this;
    var url;
    let Indexs = e.currentTarget.dataset.index; //获取点击的下拉列表的下标
    console.log(Indexs),
    console.log(that.data.Healthmedicine[0]),
    wx.request({
      url: 'http://localhost:8080/Healthy/medicine-servlet',
      method: "POST",
      header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
      data: {
        sort:that.data.Healthmedicine[e.currentTarget.dataset.index]
      },
      success: function(res){
        console.log("health"+res.data),
        wx.showToast({
          title: '添加成功',
          
        })
        that.setData({
          healthlist:res.data,
        });
      }
     })
  },
})




  
 

