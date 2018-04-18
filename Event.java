package track;

public class Event {
	private String eventName;
	private String eventType;
	private String distance;
	private String bestDistance = "";
	private boolean best;

	public Event() {

	}

	public Event(String en) {
		eventName = en;
	}

	public void setEventName(String ev) {
		eventName = ev;
	}

	public void setDistance(String d) {
		distance = d;
		if (bestDistance.equals(""))
			bestDistance = distance;
		else
			checkBestDistance(distance);
	}

	public void setEventType(String f) {
		eventType = f;
	}

	public void setBestDistance(String b) {
		bestDistance = b;
	}
	
	public boolean isBest(){
		return best;
	}
	
	public void resetBest(){
		best=false;
	}

	public void checkBestDistance(String d) {
		try {
			if (!d.equals("NH") && !d.equals("SCR")&&!d.equals("ND")&&!d.equals("NT")&&!d.equals("DNP")&&!d.equals("DNS")&&!bestDistance.equals("NH") && !bestDistance.equals("SCR")&&!bestDistance.equals("ND")&&!bestDistance.equals("NT")&&!bestDistance.equals("DNS")&&!bestDistance.equals("DNP")) {
				double tempNew = Double.parseDouble(d.replaceAll("[-:]", ""));
				double tempOld = Double.parseDouble(bestDistance.replaceAll("[-:]", ""));
				if (eventType.equals("F")) {
					if (tempNew > tempOld) {
						bestDistance = d;
						best=true;
					}else{
						best=false;
					}

				} else {
					if (tempNew < tempOld) {
						bestDistance = d;
						best=true;
					}else{
						best=false;
					}
				}
			}else if(bestDistance.equals("NH") || bestDistance.equals("SCR")||bestDistance.equals("ND")||bestDistance.equals("NT")||bestDistance.equals("DNS")||bestDistance.equals("DNP")){
				bestDistance=d;
			}
		} catch (NumberFormatException nfe) {
			bestDistance = "";
			nfe.printStackTrace();
		}

	}

	public String getEventName() {
		return eventName;
	}

	public String getDistance() {
		return distance;
	}

	public String getEventType() {
		return eventType;
	}

	public String getBestDistance() {
		return bestDistance;
	}
}
