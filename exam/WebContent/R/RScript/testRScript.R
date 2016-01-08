
DoubleArrayScatterPlot<-function(x,y){
  opar<-par(no.readonly = TRUE)
  par(cex.axis=3, font.axis=3)
  plot(x,pch=15, type='b',cex=5, lty=1, col='red')+points(y,type='b',pch=17,cex=5, lty=2,col='blue')
  axis(1,10:length(x))
  axis(2,x)
  par(opar)  
}
 