using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Domain.External
{
    public class VentataProduct
    {
        public Guid Id { get; set; }
        public decimal Cost { get; set; }
        public decimal CurrentSupply { get; set; }
        public DateTime DateAvailable { get; set; }
        public DateTime DateCreated { get; set; }
        public DateTime DateExpires { get; set; }
        public string Description { get; set; }
        public string MANUCODE { get; set; }
        public decimal MaxPrice { get; set; }
        public decimal MinPrice { get; set; }
        public string Name { get; set; }
        public decimal Price { get; set; }
        public string SKU { get; set; }
        public decimal StartingSupply { get; set; }
        public string Strategy { get; set; }
        public string StoreCode { get; set; }
    }
}
