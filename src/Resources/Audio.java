package Resources;



public class Audio {
		private static String URL;
		private static Pista sound;
		private static boolean silencio=false;
		public static void setURL(String a){
			URL=a;
		}
		public static String getURL(){
			return(URL);
		}
		public static void startAudio(){
			sound=new Pista(URL,0);
			sound.play();
		}
		public static void change(){
			sound.stop();
			if(!silencio){
				sound=null;
				sound=new Pista(URL,0);
				sound.play();
			}
		}
		public static void cerrar(){
			sound.stop();
		}
		public static void silencePlease(){
			silencio=true;
		}
		public static void speakPlease(){
			silencio=false;
		}
}
