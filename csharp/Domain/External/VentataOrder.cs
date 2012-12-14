using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Domain.External
{
    public class VentataOrder
    {
        public Guid Id { get; set; }
        public DateTime DateCreated { get; set; }
        public decimal SubTotal { get; set; }
        public decimal Taxes { get; set; }
        public decimal ShippingCost { get; set; }
        public decimal TotalPrice { get; set; }
        public List<VentataOrderDetail> OrderDetails = new List<VentataOrderDetail>();
    }

    public class VentataOrderDetail
    {
        public Guid ProductId { get; set; }
        public decimal PricePaid { get; set; }
        public decimal CostPerItem { get; set; }
        public decimal Quantity { get; set; }
    }
}
