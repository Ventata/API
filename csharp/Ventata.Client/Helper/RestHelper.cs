using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Net;
using System.IO;

namespace Ventata.Client.Helper
{
    public class RestHelper
    {
        public const string VentataAPILocation = "https://api.ventata.com/";

        public static string CallResource(string method, string resource, string json = null)
        {
            string jsonResponse = string.Empty;

            try
            {
                WebRequest CreateWebRequest = WebRequest.Create(String.Format("{0}{1}", VentataAPILocation, resource));
                CreateWebRequest.Method = method;
                CreateWebRequest.ContentType = "application/json";

                HttpWebRequest httpCreateWebRequest = (HttpWebRequest)CreateWebRequest;
                httpCreateWebRequest.UseDefaultCredentials = true;

                if (!string.IsNullOrWhiteSpace(json))
                {
                    byte[] arr = System.Text.Encoding.UTF8.GetBytes(json);

                    httpCreateWebRequest.ContentLength = arr.Length;
                    Stream dataStream = httpCreateWebRequest.GetRequestStream();
                    dataStream.Write(arr, 0, arr.Length);
                    dataStream.Close();
                }

                HttpWebResponse response = (HttpWebResponse)httpCreateWebRequest.GetResponse();
                jsonResponse = new StreamReader(response.GetResponseStream()).ReadToEnd();
            }
            catch (Exception ex)
            {
                if (ex is WebException)
                {
                    WebResponse x = ((WebException)ex).Response;
                }
            }

            return jsonResponse;
        }
    }
}
