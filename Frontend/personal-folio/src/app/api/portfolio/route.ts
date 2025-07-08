export async function GET(request: Request) {

  await new Promise((resolve) => setTimeout(resolve, 1000));
  return new Response(JSON.stringify({ message: "Hello from the API!" }), {
    headers: { "Content-Type": "application/json" },
  });
}      

