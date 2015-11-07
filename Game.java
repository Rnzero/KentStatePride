import java.util.Scanner;

public class Game 
	{
	static int [] arr = new int [20];                         //storing the number of knocked down pins in an array (Through the Roll(pins) Method)
	static int RollCount=0;
	static int s=0;
	static Scanner in = new Scanner(System.in);
	public static void Score()                              // Score() Method as requested in the specification
		{
		int a,b,c,d,e,f;
		for(int i=0;i<20;i++)
			{
			if((i%2==0)&&(i<17))                              //For the first 9 frames
				{
				int buff=i;
				a=arr[buff]; b=arr[buff+1]; c=arr[buff+2]; d=arr[buff+3];   // why assign the array values to other variables?? For convenience reasons
				i++;
				if((arr[buff]+arr[buff+1]==10)&&(arr[buff]!=10))                      //counts as spare
					{s=s+a+b+c;}
				else if ((arr[buff]+arr[buff+1]==10)&&(arr[buff]==10))                  //counts as strike
					{s=s+a+b+c+d+10;}
				else                                                                  //neither a strike nor a spare
					{ s=s+a+b; }
				}
			 else if(i==18)                                         // Considering the last frame as there's a slight change in rules when there's a Strike/Spare in the last frame (Basically provide another frame/roll)
				{
				e=arr[18];
				f=arr[19];
				if(e==10)                                                     //strike in last frame
					{
					System.out.println("Strike in the last Frame!! Enter the pins knocked down in the next two rolls");
					int x= in.nextInt();
					int y= in.nextInt();
					s=s+e+f+x+y+10;
					}
				else if((e!=10)&&(e+f==10))                               //spare in the last frame
					{
					System.out.println("Spare in the last Frame!! Enter the number of pins knocked down in the next roll");
					int z= in.nextInt();
					s=s+e+f+z;
					}
				else                                                        // neither a spare nor a strike occurred in the last frame
					{s=s+e+f;}
				}
			}
		System.out.println("\n Congratulations!! (or not) Your total Score is "+s);
		}
	public static void Roll (int pins)                    // Roll Method as requested in the specification
		{
		arr[RollCount]=pins;                            // This method just stores individual roll scores in an array
		RollCount++;
		}
	public static void main(String[] args)            //Main 
		{
		int k,pins;
		for(k=0;k<20;k++)
		    {
			System.out.println("Enter the number of Pins knocked down in this Roll");
			pins = in.nextInt();                                  //Dynamically Accepts the knocked down pins for every roll
			Roll(pins);                                           //Arguments as requested by in the requirement specification 
			}
		Score();                                                // As requested in the specification
		}
	}


// Whoop!! Done :D

//  Samuel Rohan Jangam
//	Banner ID : 810844282
//	Kent State University
//	Computer Science
//	email : samuel.ron123@gmail.com
//	email : sjangam@kent.edu
//	Phone : +1(234)281-6052*/
