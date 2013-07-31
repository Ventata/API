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
        public DateTime DateCreated { get; set; }
        public string Description { get; set; }
        public string MANUCODE { get; set; }
        public decimal MaxPrice { get; set; }
        public decimal MinPrice { get; set; }
        public string Name { get; set; }
        public decimal Price { get; set; }
        public string SKU { get; set; }
        public string Strategy { get; set; }
        public string StoreCode { get; set; }

        //Limited Supply Options
        public int StartingSupply { get; set; }
        public int CurrentSupply { get; set; }
        public DateTime DateAvailable { get; set; }
        public DateTime DateExpires { get; set; }

        // Appointment options
        public DateTime FirstAppt { get; set; }
        public DateTime LastAppt { get; set; }

        //Capacity Control Options
        public decimal CapacityCurb { get; set; }
        public decimal CapacityBaselinePrice { get; set; }

        //Hide in public API
        public decimal ProfitRate { get; set; }

        //Hide in public API  
        public decimal PriceGroup { get; set; }

        public bool PriceTracking { get; set; }
        public string RazorPriceMethod { get; set; }
        public decimal RazorPriceAmount { get; set; }
    }
}
