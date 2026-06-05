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

            output_pdf = f"{output_prefix}_{i +1}.pdf"
            
            with open(output_pdf, 'wb') as output_file:
                writer.write(output_file)

            print(f"Sezione {i + 1}: Pagine {start_page} a {end_page} salvata in '{output_pdf}'.")

input_pdf = "sm/book somerville.PDF" 
page_ranges = [(102,136),(491,518),(642,665),(668,698)]  
output_prefix = "sm/chapters_s/chapter_"

chapters(input_pdf, page_ranges, output_prefix)