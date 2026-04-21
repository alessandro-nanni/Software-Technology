from pypdf import PdfReader, PdfWriter

def extract_pdf_pages(input_file, output_file, start_page, end_page):
    """
    Extracts a range of pages from a PDF and saves them to a new file.
    
    Parameters:
    input_file (str): Path to the original PDF.
    output_file (str): Path where the new PDF will be saved.
    start_page (int): The first page to extract (1-based index).
    end_page (int): The last page to extract (inclusive).
    """
    try:
        # Open the original PDF
        reader = PdfReader(input_file)
        writer = PdfWriter()

        # Check if the requested range is valid
        total_pages = len(reader.pages)
        if start_page < 1 or end_page > total_pages or start_page > end_page:
            print(f"Error: Invalid page range. The document has {total_pages} pages.")
            return

        # PDF pages are 0-indexed in the library, but humans use 1-indexed.
        # We subtract 1 from the start_page to align with Python's indexing.
        start_index = start_page - 1
        end_index = end_page 

        # Add the specified pages to the writer object
        for i in range(start_index, end_index):
            writer.add_page(reader.pages[i])

        # Write the extracted pages to the new file
        with open(output_file, "wb") as out_pdf:
            writer.write(out_pdf)
            
        print(f"Success! Pages {start_page} to {end_page} saved to '{output_file}'.")

    except FileNotFoundError:
        print(f"Error: The file '{input_file}' was not found.")
    except Exception as e:
        print(f"An unexpected error occurred: {e}")

# --- Example Usage ---
if __name__ == "__main__":
    # Replace these with your actual file names
    source_pdf = "ldsw/pdfs/enhancing public procurement.pdf"
    destination_pdf = "ldsw/pdfs/enhancing public procurement trim.pdf"
    
    extract_pdf_pages(source_pdf, destination_pdf, start_page=462, end_page=477)