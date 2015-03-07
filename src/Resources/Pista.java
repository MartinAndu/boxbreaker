package Resources;
import java.io.File;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Pista{
	private Clip song;
	private int tipo;
	private Sequence Sec;
	private Sequencer Reproductor;
	private boolean paused=false;
	
	public Pista(String path,int tipVal){
		tipo=tipVal;
		try{
			if(tipVal==0){
				Sec=MidiSystem.getSequence(new File(path));	
			}
			if(tipVal==1){
				song=AudioSystem.getClip();
				song.open(AudioSystem.getAudioInputStream(new File(path)));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void play(){
		if(tipo==0){
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
		if(tipo==1){
			song.start();
		}
	}

	public void pause(){
		paused=true;
		Reproductor.stop();
	}
	
	public void stop(){
		if(tipo==0){
			paused=false;
			Reproductor.close();
		}
		if(tipo==1){
			song.close();
		}
	}
}
