import PyPDF2

def chapters(input_pdf, page_ranges, output_prefix):
    # Apri il file PDF in modalità lettura binaria
    with open(input_pdf, 'rb') as pdf_file:
        # Crea un lettore PDF
        reader = PyPDF2.PdfReader(pdf_file)
        
        for i, (start_page, end_page) in enumerate(page_ranges):
            writer = PyPDF2.PdfWriter()

            for page_num in range(start_page - 1, end_page):
                writer.add_page(reader.pages[page_num])

            output_pdf = f"{output_prefix}_{i + 2}.pdf"
            
            with open(output_pdf, 'wb') as output_file:
                writer.write(output_file)

            print(f"Sezione {i + 1}: Pagine {start_page} a {end_page} salvata in '{output_pdf}'.")

input_pdf = "ds/book.pdf" 
page_ranges = [(17,125),(197,262),(263,339),(407,476),(477,560),(561,630)]  
output_prefix = "ds/chapters/"

chapters(input_pdf, page_ranges, output_prefix)