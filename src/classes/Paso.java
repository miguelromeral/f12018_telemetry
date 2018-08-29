package classes;

public class Paso
{
    private boolean cerrado=false;

    public synchronized void mirar()
    {
        while(cerrado)
        {
            try
            {
                wait();
            } catch(InterruptedException ie){ }
        }
    }
    
    public synchronized void abrir()
    {
        cerrado=false;
        notifyAll();
    }
    
    public synchronized void cerrar()
    {
        cerrado=true;
    }
}
