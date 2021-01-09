/*
  Kelas untuk menghitung f(x,y,z) menggunakan metode runge kutta 4th ORDER

  @author Mauriza Humaira 
  @version 11/01/2021
*/
public class RungeKutta4Th
{
    //FUNGSI y  
    double dydx(double x, double y) {
        return (-2*y + 4 * Math.exp(-x));
    }

    //FUNGSI z
    double dzdx(double y, double z) {
        return (- (y * (Math.pow(z, 2.0)) / 3));
    }

    //Inti Kalkulator
    String rungeKutta(double x0, double y0, double z0, double x, double h) {
        double ky1, ky2, ky3, ky4;        
        double kz1, kz2, kz3, kz4;
        
        int n = (int) ((x - x0) / h);
        double y = y0; 
        double z = z0;

        // dicari nilai fungsi sampai batas n
        for(int i = 1; i <= n; i ++) {
            //fungsi y
            ky1 = (dydx(x0, y)); 
            ky2 = (dydx(x0 + 0.5 * h, y + 0.5 * ky1 * h)); 
            ky3 = (dydx(x0 + 0.5 * h, y + 0.5 * ky2 * h)); 
            ky4 = (dydx(x0 + h, y + ky3 * h)); 
           
            //fungsi z 
            kz1 = (dzdx(y, z));
            kz2 = (dzdx(y + 0.5 * kz1 * h, z + 0.5 * kz1 * h));
            kz3 = (dzdx(y + 0.5 * kz2 * h, z + 0.5 * kz2 * h));
            kz4 = (dzdx(y + kz3 * h, z + kz3 * h));   
                   
            //update y 
            y = y + (h / 6.0) * (ky1 + 2 * ky2 + 2 * ky3 + ky4); 

            //update z 
            z = z + (h / 6.0) * (kz1 + 2 * kz2 + 2 * kz3 + kz4) ;

            //update x 
            x0 = x0 + h; 
        }
        
        return 
        ">> x = " +x+ "               <<\n>> y = " +y+ 
        "<<\n>> z = " +z+ "<<" ;
    }

    
    public static void main(String[] ar) {
        RungeKutta4Th rg = new RungeKutta4Th();

        System.out.println("\n===RUNGE KUTTA 4TH ORDER===");
        System.out.println(">> dy/dx = -2y + 4e^(-x) <<");
        System.out.println(">> dz/dx = - yz^2 / 3    <<"); 
        System.out.println(">> x     = 0 s/d 1       <<");
        System.out.println(">> h     = 0.2           <<");
        System.out.println(">> y(0)  = 2             <<");
        System.out.println(">> z(0)  = 4             <<");
        System.out.println("========= JAWABAN =========");

        System.out.println(rg.rungeKutta(0, 2, 4, 1, 0.2));

        System.out.println("===========================\n");


    }
}