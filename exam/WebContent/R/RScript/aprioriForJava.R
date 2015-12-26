aprioriForJava<-function()
{
  library(Matrix)
  library(grid)
  library(arules)
  library(arulesViz)
  library(RColorBrewer)
  
  
  #导入数据
  groceries <- read.transactions('/Users/vengeance/Documents/workspaceMars/exam/WebContent/R/Rimag/temp.csv', 
                                 format='basket', 
                                 sep=',', 
                                 encoding = 'UTF-8');
  
  #知识关联处理前的图
  #sup柱状图(垂直)
  png("/Users/vengeance/Documents/workspaceMars/exam/WebContent/R/Rimag/itemFrequencyPlot1.png", width = 5000, height = 3000)
  par(cex.axis = 5)
  itemFrequencyPlot(groceries)
  dev.off()
  
  #sup柱状图（水平，前十）
  png("/Users/vengeance/Documents/workspaceMars/exam/WebContent/R/Rimag/itemFrequencyPlot2.png")
  itemFrequencyPlot(groceries,topN=10, horiz=T)
  dev.off()
  
  #求频数集
  frequentsets=eclat(groceries,parameter=list(support=0.05,maxlen=10))
  
  #删除单知识点出现情况
  basketSize<-size(groceries) 
  groceries_use <- groceries[basketSize > 1]
  #调用apriori函数
  groceryrules <- apriori(groceries_use, 
                          parameter = list(support = 0.006,
                                           confidence = 0.6,
                                           minlen = 2))
  #导出关联数据
  write(groceryrules, 
        file='/Users/vengeance/Documents/workspaceMars/exam/WebContent/R/Rimag/groceryrules.csv', 
        sep=',',
        quote=TRUE,
        row.names=FALSE)
  
  #sup/conf/lift三者的关系图
  png("/Users/vengeance/Documents/workspaceMars/exam/WebContent/R/Rimag/ScottPlot.png")
  plot(groceryrules,
       control=list(jitter=2,
       col = rev(brewer.pal(9, "Greens")[4:9])),
       shading = "lift")  
  dev.off()
  
  #知识点关系矩阵图(字体大小本宝宝改不来)
  png("/Users/vengeance/Documents/workspaceMars/exam/WebContent/R/Rimag/GroupedMatrix.png", width = 6000, height = 6000)
  par(cex.axis = 7)
  plot(groceryrules, 
       method="grouped",     
      control=list(col = rev(brewer.pal(9, "Greens"))))  
  dev.off()
  
  #知识关联网图（由于这个图片生成的效率太低，所以不设置大小）
  png("/Users/vengeance/Documents/workspaceMars/exam/WebContent/R/Rimag/Graph.png")
  plot(groceryrules, 
       measure="confidence", 
       method="graph",
       control=list(type="items"),
       shading = "lift")
  dev.off()
}