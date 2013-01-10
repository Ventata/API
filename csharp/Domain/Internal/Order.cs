using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Domain.Internal
{
    // You'll want to edit this to make it look like your Order entity
    // or just go ahead and directly use your Order object
    public class Order
    {
        public int Id { get; set; }
        public DateTime DateOrdered { get; set; }
        public decimal SubTotal { get; set; }
        public decimal Taxes { get; set; }
        public decimal Shipping { get; set; }
        public decimal Total { get; set; }
        public string PaymentMethod { get; set; }        
        public List<OrderDetail> OrderDetails = new List<OrderDetail>();
    }

    public class OrderDetail
    {
        public int Id { get; set; }
        public int OrderId { get; set; }
        public int ProductId { get; set; }
        public decimal Price { get; set; }
        public decimal Cost { get; set; }
        public decimal Quantity { get; set; }
    }
}
