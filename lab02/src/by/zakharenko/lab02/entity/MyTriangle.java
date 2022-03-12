package by.zakharenko.lab02.entity;

public class MyTriangle extends AbstractFigure{
    public boolean addPoint(Point point){
        if(pointList.size() < 3){
            pointList.add(point);
            return true;
        } else {
            return false;
        }
    }

    public void removePoint(){
        if(!pointList.isEmpty()){
            pointList.remove(pointList.size() - 1);
        }
    }

    @Override
    public boolean isAllPoints() {
        return pointList.size() == 3;
    }
}
