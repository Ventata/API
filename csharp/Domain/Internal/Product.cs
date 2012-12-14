using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Domain.Internal
{
    public class Product
    {
        public int Id { get; set; }
        public DateTime DateCreated { get; set; }
        public decimal Cost { get; set; }
        public decimal Price { get; set; }
        public string Name { get; set; }
        public string DescrLong { get; set; }
        public string DescrShort { get; set; }
        public int Supply { get; set; }
        public decimal MAP { get; set; }
        public string SKU { get; set; }
        public string ManufacturerNo { get; set; }
        public decimal width { get; set; }
        public decimal height { get; set; }
        public decimal depth { get; set; }
        public decimal weight { get; set; }
    }
}
