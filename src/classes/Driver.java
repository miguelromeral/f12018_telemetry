package classes;

import Packets.CarStatusData;
import Packets.CarTelemetryData;
import Packets.LapData;
import Packets.ParticipantData;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author miguelangel.garciar
 */
public class Driver {
    
    public CarStatusData carStatus;
    public CarTelemetryData carTelemetry;
    public ParticipantData participant;
    public LapData lap;
    public Session session;
    
    public float bestS1;
    public float bestS2;
    public float bestS3;
    public float lastS1;
    public float lastS2;
    public float lastS3;
    
    public Driver(ParticipantData pd, Session session){
        participant = pd;
        this.session = session;
        initializeSectores();
    }
    
    public void initializeSectores(){
        bestS1 = Float.POSITIVE_INFINITY;
        bestS2 = Float.POSITIVE_INFINITY;
        bestS3 = Float.POSITIVE_INFINITY;
        lastS1 = Float.POSITIVE_INFINITY;
        lastS2 = Float.POSITIVE_INFINITY;
        lastS3 = Float.POSITIVE_INFINITY;
    }
    
    public float getLastS1(){
        if(lastS1 == Float.POSITIVE_INFINITY){
            return 0f;
        }else{
            return lastS1;
        }
    }
    
    public float getLastS2(){
        if(lastS2 == Float.POSITIVE_INFINITY){
            return 0f;
        }else{
            return lastS2;
        }
    }
    
    public float getLastS3(){
        if(lastS3 == Float.POSITIVE_INFINITY){
            return 0f;
        }else{
            return lastS3;
        }
    }
    
    public void setNewLap(LapData newLap){
        lap = newLap;
        if(lap.getSector() != 1 && lap.sector1Time != 0f){
            lastS1 = lap.sector1Time;
            if(lastS1 < bestS1){
                bestS1 = lastS1;
                if(bestS1 <= session.bestS1){
                    session.bestS1 = bestS1;
                }
            }
        }
        if(lap.getSector() == 3 && lap.sector1Time != 0f){
            lastS2 = lap.sector2Time;
            if(lastS2 < bestS2){
                bestS2 = lastS2;
                if(bestS2 < session.bestS2){
                    session.bestS2 = bestS2;
                }
            }
        }
        if(lap.getSector() == 1 && lap.lastLapTime != 0f){
            lastS3 = lap.lastLapTime - lastS1 - lastS2;
            if(lastS3 < bestS3){
                bestS3 = lastS3;
                if(bestS3 < session.bestS3){
                    session.bestS3 = bestS3;
                }
            }
        }
        if(lap.getSector() == 1){
            if(lap.lastLapTime != 0f && lap.lastLapTime == lap.bestLapTime && session.betterThanLap(lap.bestLapTime)){
                session.bestLap = lap.bestLapTime;
            }
        }
    }
    
    public void setNewParticipant(ParticipantData pd){
        if(pd.driverId != participant.driverId){
            participant = pd;
        }
    }
    
    public void setNewCarTelemetry(CarTelemetryData ctd){
        carTelemetry = ctd;
    }
    
    public void setNewCarStatus(CarStatusData csd){
        carStatus = csd;
    }
}
