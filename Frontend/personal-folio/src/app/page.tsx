import Card from "@/components/card/Card";

export default function Home() {
  return (
    <main className="flex flex-col gap-8">
      <section className="flex justify-center bg-primary p-8 rounded">
        <div>
          <Card />
        </div>
      </section>
    </main>
  );
}
