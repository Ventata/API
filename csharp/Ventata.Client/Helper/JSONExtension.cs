using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using System.Web;
using System.Runtime.Serialization.Json;

namespace Ventata.Client.Helper
{
    public static class JSONExtension
    {
        public static T FromJSON<T>(this string json)
        {
            if (!string.IsNullOrEmpty(json))
            {
                json = HttpUtility.HtmlDecode(json);

                using (MemoryStream ms = new MemoryStream(Encoding.UTF8.GetBytes(json)))
                {
                    DataContractJsonSerializer serializer = new DataContractJsonSerializer(typeof(T));
                    return (T)serializer.ReadObject(ms);
                }
            }
            else
            {
                return default(T);
            }
        }

        public static string ToJSON(this object obj)
        {
            string json = string.Empty;

            if (obj != null)
            {
                DataContractJsonSerializer serializer = new DataContractJsonSerializer(obj.GetType());
                using (MemoryStream ms = new MemoryStream())
                {
                    serializer.WriteObject(ms, obj);
                    json = Encoding.UTF8.GetString(ms.ToArray());
                }
            }

            return json;
        }
    }
}
