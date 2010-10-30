package Generic;
import java.io.File;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.Clip;


public class Pista{
	private Clip song;
	private int tipo;
	private Sequence Sec;
	private Sequencer Reproductor;
	private boolean paused=false;
	
	public Pista(String path,int tipVal){
		if(tipVal==0){
			try{
				Sec=MidiSystem.getSequence(new File(path));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public void play(){
		if(!paused){
			try {
				Reproductor=MidiSystem.getSequencer();
				Reproductor.open();
				Reproductor.setSequence(Sec);
				Reproductor.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
			} catch (Exception e) {
				e.printStackTrace();	
			}
		}else{
			paused=false;
		}
		Reproductor.start();
	}

	public void pause(){
		paused=true;
		Reproductor.stop();
	}
	
	public void stop(){
		paused=false;
		Reproductor.close();
	}
}
