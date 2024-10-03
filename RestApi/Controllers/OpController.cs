using Microsoft.AspNetCore.Mvc;
using RestApi.Models;
using RestApi.Services;

namespace RestApi.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class OpController : ControllerBase
    {
        private readonly OpService ops;

        public OpController(OpService ops1)
        {
            ops = ops1;
        }

        [HttpPost("calc")]
        public IActionResult Calculate([FromBody] Entity ops1)
        {
            try
            {
                var result = ops.GetResult(ops1);
                return Ok(result);
            }
            catch (Exception ex)
            {
                return BadRequest(ex.Message);
            }
        }
    }
}
