using System;
using RestApi.Models;

namespace RestApi.Services
{
    public class OpService
    {
        public int Operation(int a, int b, string op)
        {
            switch(op) {
            case "add" : return a + b;
            case "sub" : return a - b;
            case "mul" : return a * b;
            case "div" :if(b == 0)
                            throw new Exception("cannot divide by zero");
                        else 
                            return a / b;
            default :  throw new Exception("Error!!");
        }
        }

        public Entity GetResult(Entity o)
        {
            o.res = Operation(o.a, o.b, o.op);
            return o;
        }

        
    }
}
