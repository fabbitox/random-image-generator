using System;
using System.Drawing;

namespace RandomImage
{
    class Program
    {
        static void Main()
        {
            int width = 960, height = 960, ac = width, colorCount = 4;
            Random random = new Random();
            Color[] colors = new Color[colorCount];
            for (int i = 0; i < colorCount; i++)
            {
                colors[i] = Color.FromArgb(random.Next(192, 256), random.Next(192, 256), random.Next(192, 256));
                //int v = random.Next(208, 256);// black and white
                //colors[i] = Color.FromArgb(v, v, v);
            }
            int[,] state = new int[width, height];
            int[] hs = new int[width], avails = new int[width];
            for (int i = 0; i < width; i++)
            {
                avails[i] = i;
            }
            while (ac > 0)
            {
                int ci = random.Next(colorCount), count = random.Next(height / 100) + 1, r = random.Next(ac);
                while (count-- > 0 && ac > 0)
                {
                    int s = random.Next(r, r + Math.Max(1, ac / 10)), c = random.Next(ac / 4) + 1;
                    for (int j = 0; j < c && ac > 0; j++)
                    {
                        int k = (s + j) % ac, k2 = avails[k];
                        while (hs[k2] == height && ac > 0)
                        {
                            k2 = avails[k] = avails[--ac];
                        }
                        if (hs[k2] < height)
                        {
                            state[k2, hs[k2]++] = ci;
                        }
                    }
                }
            }
            using (Bitmap bitmap = new Bitmap(width, height))
            {
                for (int i = 0; i < width; i++)
                {
                    for (int j = 0; j < height; j++)
                    {
                        bitmap.SetPixel(i, height - 1 - j, colors[state[i, j]]);
                    }
                }
                bitmap.Save("output.png", System.Drawing.Imaging.ImageFormat.Png);
            }
        }
    }
}
