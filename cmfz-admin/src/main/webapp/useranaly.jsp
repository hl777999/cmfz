<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/echarts.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/china.js"></script>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('statistics_china'));
    option = {
        title: {
            text: '持名法州APP用户分布图',
            subtext: '2018年7月9日 最新数据',
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        // 说明
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['男', '女']
        },
        visualMap: {
            min: 0,
            max: 2500,
            left: 'left',
            top: 'bottom',
            text: ['高', '低'],           // 文本，默认为数值文本
            calculable: true
        },
        // 工具箱
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                dataView: {readOnly: false},
                restore: {},
                saveAsImage: {}
            }
        },
        series: [
            {
                name: '男',
                type: 'map',
                mapType: 'china',
                roam: false,
                label: {
                    normal: {
                        show: true
                    },
                    emphasis: {
                        show: true
                    }
                },
                data: []
            },
            {
                name: '女',
                type: 'map',
                mapType: 'china',
                label: {
                    normal: {
                        show: true
                    },
                    emphasis: {
                        show: true
                    }
                },
                data: []
            }
        ]
    };
    myChart.setOption(option);
    $(function () {
        $.post("${pageContext.request.contextPath}/user/querall",{sex:"男"}, function (data) {
            console.log(data);
            myChart.setOption({
                series: [{
                    // 根据名字对应到相应的系列
                    type: 'map',
                    mapType: 'china',
                    name: '男',
                    data: data
                }]
            });
        }, "json");

        $.post("${pageContext.request.contextPath}/user/querall",{sex:"女"}, function (data) {
            console.log(data);
            myChart.setOption({
                series: [{
                    // 根据名字对应到相应的系列
                    type: 'map',
                    mapType: 'china',
                    name: '女',
                    data:data
                }]
            });
        }, "json");
    });
</script>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="statistics_china" style="width: 97%;height: 95%;margin-top: 30px;margin-left: 30px">
</div>


