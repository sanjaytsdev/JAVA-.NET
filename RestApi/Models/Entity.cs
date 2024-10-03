namespace RestApi.Models;

public class Entity
{
   public int a { get; set; }
   public int b { get; set; }

   public string? op { get; set; }
   public int? res { get; set; }
}

 public class ErrorViewModel
    {
        public string RequestId { get; set; }

        public bool ShowRequestId => !string.IsNullOrEmpty(RequestId);
    }