package aroundme;

import java.util.Collection;
import java.util.Iterator;

import utils.LatLongUtils;
import kdtree.KdTree;
import kdtree.KdTree.XYZPoint;

public class Driver {
	private KdTree<XYZPoint> points;

	public Driver() {
		super();
		points = new KdTree<KdTree.XYZPoint>();
	}
	
	public void addPoint(double latitude, double longitude, String description){
		points.add(new XYZPoint(longitude, latitude,description));
	}
	
	public Collection<XYZPoint> nearestInterests(double latitude, double longitude,int k){
		return points.nearestNeighbourSearch(k, new XYZPoint(longitude, latitude));
	}
	
	public void nearestInterestsAndDistances(double latitude, double longitude, int k){
		Collection<XYZPoint> nearestPoints = points.nearestNeighbourSearch(k, new XYZPoint(longitude, latitude));
		
		Iterator<XYZPoint> iterator = nearestPoints.iterator();
		while(iterator.hasNext()){
			XYZPoint currentPoint = iterator.next();
			double distance = LatLongUtils.distance(latitude, longitude, currentPoint.getY(), currentPoint.getX());
			String output = String.format("%s is %.3fm away", currentPoint.getDescription(), distance);
			System.out.println(output);
		}
			
	}
	

}
