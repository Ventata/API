using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Domain.External
{
    public class VentataStore
    {
        public Guid Id { get; set; }
        public string Name { get; set; }
        public string URL { get; set; }
        public Guid ApiKey { get; set; }
        public StoreType StoreType { get; set; }
        public string CurrencyCode { get; set; }
        public string ExternalId { get; set; }
    }

    public class StoreType
    {
        public int Id { get; set; }
        public string Name { get; set; }
    }
}
