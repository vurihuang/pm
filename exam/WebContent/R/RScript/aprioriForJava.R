aprioriForJava<-function()
{
  #导入关联分析所需要的包
  library(Matrix)
  library(grid)
  library(arules)
  library(arulesViz)
  library(RColorBrewer)
  
  # 解决跨平台乱码问题
  system("defaults write org.R-project.R force.LANG en_US.UTF-8")
  
  #导入分析数据
  trans<- read.transactions('D:/R/temp/use/Relation.csv', 
                               format='basket', 
                               sep=',', 
                               encoding = 'UTF-8');
 
   #生成频数集,并写入csv文件
  fsets<-eclat(trans,parameter = list(support=0.05))
  quality(fsets)=round(quality(fsets),digits=3)
  write(fsets,
        file='D:/R/temp/Relation/fstes.csv',
        sep=',',
        quote=TRUE)
 
   # sup柱状图
  supp <- 0.05
  epsilon <- 0.1
  c <- 0.1
  n <- -2 * log(c)/ (supp * epsilon^2) 
  trans.sample <- sample(trans, n, replace = TRUE)
  png("D:/R/temp/Relation/fsetsSup.png")
  itemFrequencyPlot(trans,
		    support=0.05, 
                    col = 'dark blue',
                    main = '知识点频数统计图') 
  dev.off()
  png("d:/R/temp/Relation/fsetsLift.png")
  itemFrequencyPlot(trans.sample, 
                    population = trans,
                    support = supp, 
                    lift = TRUE,
                    cex.names = 0.9,
                    col='dark blue',
                    horiz=TRUE, 
                    main='提升比率统计图')
  dev.off()
  
  # 删除单个知识点的试卷情况
  basketSize<-size(trans)
  trans.use <- trans[basketSize > 1]
  
  #关联规则分析
  rules <- apriori(trans.use, 
                  parameter = list(support = 0.006,
                  confidence = 0.6,
                  minlen = 2))
  quality(rules)=round(quality(rules),digits=3)
  rules<-subset(rules, support>0.01 & lift < 15)
  
  #三个值的分布图
  png("D:/R/temp/Relation/ScottPlot.png")
  plot(rules,
       control=list(jitter=2,col = rev(brewer.pal(9, "Blues"))),
       shading = "lift")  
  dev.off()
  
  #删除冗余规则
  subset.matrix <- is.subset(rules, rules)
  subset.matrix[lower.tri(subset.matrix, diag = T)] <- NA
  redundant <- colSums(subset.matrix, na.rm = T) >= 1
  rules.pruned <- rules[! redundant]
  
  #导出关联分析结果
  write(rules.pruned,
        file='D:/R/temp/Relation/rules.csv',
        sep=',',
        quote=TRUE,
        row.names=FALSE)
  
  #知识点关系矩阵图
  png("D:/R/temp/Relation/GroupedMatrix.png", width = 1000, height = 1500)
  par(cex.axis = 7, font.axis=5)
  plot(rules.pruned, 
      method="grouped",     
      control=list(col = rev(brewer.pal(9, "Blues"))),
      main='知识点关系矩阵图')  
  dev.off()
  
  #知识点关联网图
  png("D:/R/temp/Relation/Graph.png", width = 1000, height = 1000)
  plot(rules.pruned, 
       measure="confidence",
       method="graph",
       control=list(type="items"),
       shading = "lift",
       main='知识点关联网图')
  dev.off()
}