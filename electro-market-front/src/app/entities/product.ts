export interface Product {
  name: string;
  priceInCents: number;
  description: string | null;
  imageFileName: string | null;
  base64Image: string | null;
}
